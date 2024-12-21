package technology.tabula.entity;

import java.io.Serializable;
import java.util.List;

/**
 * [
 *     {
 *         "extraction_method":"stream",
 *         "page_number":1,
 *         "top":0.0,
 *         "left":0.0,
 *         "width":595.2760009765625,
 *         "height":841.8900146484375,
 *         "right":595.276,
 *         "bottom":841.89,
 *         "data":
 *         [
 *             [
 *                 {
 *                     "top":83.54,
 *                     "left":40.0,
 *                     "width":258.53997802734375,
 *                     "height":6.449999809265137,
 *                     "text":"编号:202411171543411361908494401233732442377"
 *                 }
 *
 *             ]
 *          ]
 *        }
 *    ]
 */
public class ExtractObjectEntity implements Serializable {

    /**
     * stream,lattice
     */
    public String extraction_method;

    public String page_number;

    public String top;

    public String left;

    public String width;

    public String height;

    public String right;

    public String bottom;

    List<List<FieldEntity>> data;

    @Override
    public String toString() {
        return "ExtractObjectEntity{" +
                "extraction_method='" + extraction_method + '\'' +
                ", page_number='" + page_number + '\'' +
                ", top='" + top + '\'' +
                ", left='" + left + '\'' +
                ", width='" + width + '\'' +
                ", height='" + height + '\'' +
                ", right='" + right + '\'' +
                ", bottom='" + bottom + '\'' +
                ", data=" + data +
                '}';
    }

    public String getExtraction_method() {
        return extraction_method;
    }

    public void setExtraction_method(String extraction_method) {
        this.extraction_method = extraction_method;
    }

    public String getPage_number() {
        return page_number;
    }

    public void setPage_number(String page_number) {
        this.page_number = page_number;
    }

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

    public String getRight() {
        return right;
    }

    public void setRight(String right) {
        this.right = right;
    }

    public String getBottom() {
        return bottom;
    }

    public void setBottom(String bottom) {
        this.bottom = bottom;
    }

    public List<List<FieldEntity>> getData() {
        return data;
    }

    public void setData(List<List<FieldEntity>> data) {
        this.data = data;
    }
}
