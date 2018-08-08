package top.jbzm.demo.annotationimagelog.common;

import lombok.AllArgsConstructor;

/**
 * @author jbzm
 * @date 20182:51 PM
 **/
@AllArgsConstructor
public enum FilePath {

    /**
     * 基础路径
     */
    BASE_PATH(1, "/var/www/cdn/images/lol"),
    PICTURE_SAVE_URL(2,"http://tiku.huatu.com/cdn/images/lol");

    private Integer value;
    private String content;

    public Integer getValue() {
        return value;
    }

    public String getContent() {
        return content;
    }
}