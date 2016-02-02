package fr.afcepf.adopteundev.managedbean.util;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;
import java.util.*;

public class UploadFilter implements Filter {
    private FilterConfig filterConfig = null;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (!(servletRequest instanceof HttpServletRequest)) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        boolean isMultipartContent = ServletFileUpload.isMultipartContent(httpServletRequest);
        if (!isMultipartContent) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setHeaderEncoding("UTF-8");
        upload.setFileSizeMax(-1);

        try {
            List<FileItem> items = upload.parseRequest(httpServletRequest);
            final Map<String, String[]> parameterMap = new HashMap<>();
            for (FileItem item :
                    items) {
                if (item.isFormField())
                    processFormField(item,parameterMap);
                else
                    processFileField(item,httpServletRequest);
            }
            filterChain.doFilter(new HttpServletRequestWrapper(httpServletRequest){
                public Map<String,String[]> getParameterMap(){return parameterMap;}
                public String[] getParameterValues(String name){return (String[])parameterMap.get(name);}
                public String getParameter(String name){
                    String[]params = getParameterValues(name);
                    if (params==null)
                        return null;
                    return params[0];
                }
                public Enumeration<String> getParameterNames(){
                    return Collections.enumeration(parameterMap.keySet());
                }
            },servletResponse);
        } catch (FileUploadException e) {
            ServletException servletException = new ServletException();
            servletException.initCause(e);
            throw servletException;
        }
    }

    @Override
    public void destroy() {
        this.filterConfig = null;
    }
    private void processFormField(FileItem formField, Map<String, String[]> parameterMap) {
        String name = formField.getFieldName();
        String value = formField.getString();
        String[] values = parameterMap.get(name);

        if (values == null) {
            parameterMap.put(name, new String[] { value });
        } else {
            int length = values.length;
            String[] newValues = new String[length + 1];
            System.arraycopy(values, 0, newValues, 0, length);
            newValues[length] = value;
            parameterMap.put(name, newValues);
        }
    }

    private void processFileField(FileItem fileField, HttpServletRequest request) {
        if (request.getAttribute(fileField.getFieldName()) == null) {
            List<FileItem> fileFields = new ArrayList<FileItem>(0);
            fileFields.add(fileField);
            request.setAttribute(fileField.getFieldName(), fileFields);
        } else {
            List<FileItem> fileFields = (List<FileItem>)request.getAttribute(fileField.getFieldName());
            fileFields.add(fileField);
        }
    }
}
