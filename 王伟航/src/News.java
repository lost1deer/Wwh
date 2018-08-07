import java.io.Serializable;

public class News implements Serializable{
    private String id;
    private String style;
    private String content;
    private String data;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getStyle() {
        return style;
    }
    public void setStyle(String style) {
        this.style = style;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
}