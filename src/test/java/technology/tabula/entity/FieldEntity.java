package technology.tabula.entity;

import java.io.Serializable;

/**
 *         "data":
 *         [
 *             [
 *                 {
 *                     "top":83.54,
 *                     "left":40.0,
 *                     "width":258.53997802734375,
 *                     "height":6.449999809265137,
 *                     "text":"编号:xxxxxxxxxxxxxxxxxxx"
 *                 }
 *
 *             ],
 *             [
 *                 {
 *                     "top":126.25,
 *                     "left":217.64,
 *                     "width":160.00001525878906,
 *                     "height":10.329999923706055,
 *                     "text":"微信支付交易明细证明"
 *                 }
 *
 *             ]
 *          ]
 */
public class FieldEntity  implements Serializable {
    private String top;
    private String left;
    private String width;
    private String height;
    private String text;

    public String getTop() {
        return top;
    }

    public void setTop(String top) {
        this.top = top;
    }

    public String getLeft() {
        return left;
    }

    public void setLeft(String left) {
        this.left = left;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "FieldEntity{" +
                "top='" + top + '\'' +
                ", left='" + left + '\'' +
                ", width='" + width + '\'' +
                ", height='" + height + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
