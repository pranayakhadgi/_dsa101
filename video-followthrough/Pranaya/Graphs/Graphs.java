package Pranaya.Graphs;

//graph --> node class--> field (string) --> addNode (label) + removeNode (label) + addEdge(from, to), removeEdge (from, to)
// print()
// A is connected with [B,c], B is connected with [A]
public class Graphs {
    private class Node {
        private String label;
        private String[] arrays;

        public Node(String label) {
            this.label = label;
            this.arrays = new String[5];
        }
    }

    private String[] arrays = new String[5];

    public void addNode(String label) {
        for(var i = 0; i < this.arrays.length; i++) { //does a for loop to check
            for(var j = 1; j < this.arrays.length - i; j++) {
                if(arrays[j] != label) {
                    arrays[j] = label;
                }
            }
        }
    }

    public void removeNode(String label) {
        for(var i = 0; i < this.arrays.length; i++) { //does a for loop to check
            for(var j = 1; j < this.arrays.length - i; j++) {
                if(arrays[j] == label) {
                    arrays[j] = null;
                }
            }
        }
    }

    public String addEdge(String from, String to) {
        //loop lagxa ra yesma?
        return null;
    }

    public String removeEdge(String from, String to) {
        //yesma pani
        return null;
    }

    public void print() {
        System.out.println("");
        //I still cannot do toString properly
    }
}

