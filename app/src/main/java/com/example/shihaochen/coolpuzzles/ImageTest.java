import java.io.File;

/**
 * This is the test for the splitting and forming a graph; it is also a demo for
 * how to use this api
 * @author Oscar Zhang
 */
public class ImageTest {

  public static void main(String[] args) {
    File img = new File("dota2_logo.jpg");
    try {
      // demo for calling this api
      ImageSplit is = new ImageSplit(2, 2, img);
      ImageGraph ig = new ImageGraph(is.getImageArray());
      /*
      Then you can call various methods in ig
      example:
      - ig.getReference() will return a reference to the upper left of the graph
      - ig.getNodeArray() will return an array with node, for each node the up, left, right, and
        down are set
       */
    } catch (Exception e) {
      System.out.println("Image not found!");
    }
  }
}
