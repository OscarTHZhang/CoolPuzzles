import java.awt.image.BufferedImage;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import javax.imageio.ImageIO;


/**
 * This class first split one image in to x * x pieces
 * @author Oscar Zhang
 */
public class ImageSplit {

  private int rows, cols; // rows and cols that is going to split
  private File img; // image file
  private FileInputStream fis; // file input stream
  private BufferedImage image; // the image object
  private BufferedImage[] imgs; // the array that stores all the image pieces

  /**
   * Initialization of the splitting image
   * @param rows number
   * @param cols number
   * @param img that is going to split
   * @throws Exception that is found in File.io
   */
  public ImageSplit(int rows, int cols, File img) throws Exception {
    this.rows = rows;
    this.cols = cols;
    this.img = img;

    this.fis = new FileInputStream(this.img);
    this.image = ImageIO.read(fis);

    this.imgs = new BufferedImage[rows*cols];
  }

  /**
   * Get the image array
   * @return imgs array that stores the image pieces
   */
  public BufferedImage[] getImageArray() {
    return this.imgs;
  }

  /**
   * Getter of the original full image
   * @return the original image
   */
  public BufferedImage getImage() { return this.image; }

  /**
   * Split images
   * @throws Exception from
   *         FileInputStream fis = new FileInputStream(img);
   *         BufferedImage image = ImageIO.read(fis);
   */
  private void splitImage() throws Exception {

    int chunks = this.rows * this.cols;
    int chunkWidth = this.image.getWidth() / this.cols;
    int chunkHeight = this.image.getHeight() / this.rows;
    int count = 0;

    for (int x = 0; x < cols; x++) {
      for (int y = 0; y < rows; y++) {
        this.imgs[count] = new BufferedImage(chunkWidth, chunkHeight, image.getType());

        Graphics2D gr = this.imgs[count++].createGraphics();
        gr.drawImage(image, 0, 0, chunkWidth, chunkHeight,
            chunkWidth * y, chunkHeight * x,
            chunkWidth * y + chunkWidth, chunkHeight * x + chunkHeight, null);
        gr.dispose();
      }
    }
    // put these image pieces into a file (images)
    for (int i = 0; i < this.imgs.length; i++) {
      ImageIO.write(this.imgs[i], "jpg", new File("images/" + i + ".jpg"));
    }

  }

  /**
   * Main method of this class, calling a test
   * @param args
   */
  public static void main(String[] args) {
    try {
      File img = new File("dota2_logo.jpg");
      ImageSplit is = new ImageSplit(2,2, img);
      is.splitImage();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
