import java.awt.image.BufferedImage;

/**
 * This is a class that stores all the image pieces in to a graph and the reference
 * of this graph will be the upper left node of the graph
 * @author Oscar Zhang
 */
public class ImageGraph {

  private Node reference; // this is the Node of the upper left node
  private BufferedImage[] originalArray;
  private Node[] nodeArray;

  /**
   * Constructor of the ImageGraph
   * @param originalArray the array that is returned from ImageSplit; can be accessed through
   * ImageSplit.getImageArray()
   */
  public ImageGraph(BufferedImage[] originalArray) {

    this.originalArray = originalArray; // the original one dimensional array of pics
    int size = this.originalArray.length; // size of the graph

    // transfer this into a two dimensional array that stores Nodes
    Node[][] twoDimensional = new Node[size][size];
    for (int i=0; i<this.originalArray.length; i++) {
      twoDimensional[i / size][i % size] = new Node(this.originalArray[i]);
    }
    this.reference = twoDimensional[0][0]; // set up the reference

    int dimension = (int) Math.sqrt(size);

    for (int r=0; r<twoDimensional.length; r++) {
      for (int c=0; c<twoDimensional[0].length; c++) {
        // exceptional cases
        if (r==0 && c==0) {
          /*
          1 0 0
          0 0 0
          0 0 0
           */
          twoDimensional[r][c].setRight(twoDimensional[r][c+1]);
          twoDimensional[r][c].setDown(twoDimensional[r+1][c]);
        } else if (r == 0 && c == dimension) {
          /*
          0 0 1
          0 0 0
          0 0 0
           */
          twoDimensional[r][c].setLeft(twoDimensional[r][c-1]);
          twoDimensional[r][c].setDown(twoDimensional[r+1][c]);
        } else if (r == dimension && c == 0) {
          /*
          0 0 0
          0 0 0
          1 0 0
           */
          twoDimensional[r][c].setUpper(twoDimensional[r-1][c]);
          twoDimensional[r][c].setRight(twoDimensional[r][c+1]);
        } else if (r == dimension && c == dimension) {
          /*
          0 0 0
          0 0 0
          0 0 1
           */
          twoDimensional[r][c].setUpper(twoDimensional[r-1][c]);
          twoDimensional[r][c].setLeft(twoDimensional[r][c-1]);
        } else if (r != dimension && r != 0 && c == 0) {
          /*
          0 0 0 0
          1 0 0 0
          1 0 0 0
          0 0 0 0
           */
          twoDimensional[r][c].setUpper(twoDimensional[r-1][c]);
          twoDimensional[r][c].setRight(twoDimensional[r][c+1]);
          twoDimensional[r][c].setDown(twoDimensional[r-1][c]);
        } else if (r != dimension && r != 0 && c == dimension) {
          /*
          0 0 0 0
          0 0 0 1
          0 0 0 1
          0 0 0 0
           */
          twoDimensional[r][c].setUpper(twoDimensional[r-1][c]);
          twoDimensional[r][c].setDown(twoDimensional[r-1][c]);
          twoDimensional[r][c].setLeft(twoDimensional[r][c-1]);
        } else if (r == 0 && c != 0 && c!= dimension) {
          /*
          0 1 1 0
          0 0 0 0
          0 0 0 0
          0 0 0 0
           */
          twoDimensional[r][c].setLeft(twoDimensional[r][c-1]);
          twoDimensional[r][c].setRight(twoDimensional[r][c+1]);
          twoDimensional[r][c].setDown(twoDimensional[r+1][c]);
        } else if (r == dimension && c != 0 && c != dimension ) {
          /*
          0 0 0 0
          0 0 0 0
          0 0 0 0
          0 1 1 0
           */
          twoDimensional[r][c].setLeft(twoDimensional[r][c-1]);
          twoDimensional[r][c].setRight(twoDimensional[r][c+1]);
          twoDimensional[r][c].setUpper(twoDimensional[r-1][c]);
        }
        // in general
        twoDimensional[r][c].setDown(twoDimensional[r+1][c]);
        twoDimensional[r][c].setUpper(twoDimensional[r-1][c]);
        twoDimensional[r][c].setLeft(twoDimensional[r][c-1]);
        twoDimensional[r][c].setRight(twoDimensional[r][c+1]);
      }
    }

    // initialization of node array
    for (int i=0; i<twoDimensional.length; i++) {
      for (int j=0; j<twoDimensional[0].length; j++) {
        this.nodeArray[i*dimension+j] = twoDimensional[i][j];
      }
    }

  }

  /**
   * Getter of the reference: upper left node
   * @return the upper left node of the graph
   */
  public Node getReference() {
    return this.reference;
  }

  /**
   * Getter of the nodeArray
   */
  public Node[] getNodeArray() {
    return this.nodeArray;
  }
}
