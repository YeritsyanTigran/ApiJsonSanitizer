package com.TigranIncorporation.sanitizer.config;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FilterServletOutputStream extends ServletOutputStream {
    DataOutputStream output;

    public FilterServletOutputStream(OutputStream output) {
        this.output = new DataOutputStream(output);
    }

    @Override
    public boolean isReady() {
        return output!=null;
    }

    @Override
    public void setWriteListener(WriteListener listener) {
    }

    @Override
    public void write(int b) throws IOException {
        output.write(b);
    }
}
