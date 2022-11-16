package com.example.democonsumer.qrcode;

import java.awt.*;

/**
 * @Author: lifengsheng
 * @Date: 2022/10/28 10:31
 * @Desc:
 */
public class LogoConfig {
    // logo默认边框颜色
    public static final Color DEFAULT_BORDER_COLOR = Color.WHITE;
    // logo默认边框宽度
    public static final int DEFAULT_BORDER = 0;
    // logo大小默认为照片的1/6
    public static final int DEFAULT_LOGO_PART = 4;

    private final Color borderColor;
    private final int logoPart;

    /**
     * Creates a default config with on color and off color,
     * generating normal black-on-white barcodes.
     */
    public LogoConfig()
    {
        this(DEFAULT_BORDER_COLOR, DEFAULT_LOGO_PART);
    }

    public LogoConfig(Color borderColor, int logoPart)
    {
        this.borderColor = borderColor;
        this.logoPart = logoPart;
    }

    public Color getBorderColor()
    {
        return borderColor;
    }

    public int getBorder()
    {
        return DEFAULT_BORDER;
    }

    public int getLogoPart()
    {
        return logoPart;
    }
}
