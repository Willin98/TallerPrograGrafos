package Runner;

import java.awt.Dimension;

import javax.swing.JFrame;

import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseMultigraph;
import edu.uci.ics.jung.graph.util.EdgeType;
import edu.uci.ics.jung.samples.SimpleGraphDraw;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;

public class RunGrafon {

	public static void main(String[] args) {
		SimpleGraphDraw sgv = new SimpleGraphDraw(); //We create our graph in here
		 Graph<Integer, String> g = new SparseMultigraph<Integer, String>();
		 g.addVertex((Integer)1);
		 g.addVertex((Integer)2);
		 g.addVertex((Integer)3);
		 // Add some edges. From above we defined these to be of type String
		 // Note that the default is for undirected edges.
		 g.addEdge("Edge-A", 1, 2); // Note that Java 1.5 auto-boxes primitives
		 g.addEdge("Edge-B", 2, 3);
		 // Let's see what we have. Note the nice output from the
		 // SparseMultigraph<V,E> toString() method
		 System.out.println("The graph g = " + g.toString());
		 // Note that we can use the same nodes and edges in two different graphs.
		 Graph<Integer, String> g2 = new SparseMultigraph<Integer, String>();
		 g2.addVertex((Integer)1);
		 g2.addVertex((Integer)2);
		 g2.addVertex((Integer)3);
		 g2.addEdge("Edge-A", 1,3);
		 g2.addEdge("Edge-B", 2,3, EdgeType.DIRECTED);
		 g2.addEdge("Edge-C", 3, 2, EdgeType.DIRECTED);
		 g2.addEdge("Edge-P", 2,3); // A parallel edge
		// The Layout<V, E> is parameterized by the vertex and edge types
		Layout<Integer, String> layout=new CircleLayout<Integer, String>(g);
		 layout.setSize(new Dimension(300,300)); // sets the initial size of the space
		 // The BasicVisualizationServer<V,E> is parameterized by the edge types
		 BasicVisualizationServer<Integer,String> vv =
		 new BasicVisualizationServer<Integer,String>(layout);
		 vv.setPreferredSize(new Dimension(350,350)); //Sets the viewing area size

		 JFrame frame = new JFrame("Simple Graph View");
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 frame.getContentPane().add(vv);
		 frame.pack();
		 frame.setVisible(true); 

	}

}
