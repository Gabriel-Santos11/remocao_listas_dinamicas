public class LinkedList {
    private Node origin;

    public LinkedList() {
        origin = null;
    }

    public Node getOrigin() {
        return this.origin;
    }

    public Node addNode(int value) {
        Node newNode = new Node(value);
        if(isEmpty()) {
            this.origin = newNode;
        } else {
            Node aux = this.origin;
            while(aux.getNext() != null) {
                aux = aux.getNext();
            }
            aux.setNext(newNode);
        }
        return newNode;
    }

    public void display() {
        if(isEmpty()) {
            System.out.println("Lista vazia.");
        } else {
            Node aux = this.origin;
            while(aux != null) {
                System.out.println(aux.getValue());
                aux = aux.getNext();
            }
        }
    }

    public void delete(int value) {
        Node nodeToDelete = findNode(value);
        if (nodeToDelete != null) {
            if (nodeToDelete == this.origin) {
                removeOrigin();
            } else if (identifyNode(nodeToDelete).equals("intermediary")) {
                removeIntermediary(nodeToDelete);
            } else if (identifyNode(nodeToDelete).equals("last")) {
                removeLast();
            }
        } else {
            System.out.println("O no não existe.");
        }
    }

    public void removeOrigin() {
        if(this.origin.getNext() == null) {
            this.origin = null;
        } else {
            this.origin = this.origin.getNext();
        }
    }

    public void removeIntermediary(Node nodeToRemove) {
        Node aux = this.origin;
        while(aux != null && aux.getNext() != nodeToRemove) {
            aux = aux.getNext();
        }
        if (aux != null) {
            aux.setNext(nodeToRemove.getNext());
        }
    }

    public void removeLast() {
        if (this.origin == null) {
            return; // Lista vazia, nada para remover
        }
        if (this.origin.getNext() == null) {
            this.origin = null; // Lista com um unico no
            return;
        }
        Node aux = this.origin;
        while (aux.getNext().getNext() != null) {
            aux = aux.getNext();
        }
        aux.setNext(null);
    }

    public String identifyNode(Node node) {
        if(node == this.origin) {
            return "origin";
        } else if (node.getNext() == null) {
            return "last";
        } else {
            return "intermediary";
        }
    }

    public Node findNode(int value) {
        Node aux = this.origin;
        while(aux != null) {
            if(aux.getValue() == value) {
                return aux;
            }
            aux = aux.getNext();
        }
        return null;
    }

    public boolean isEmpty() {
        return this.origin == null;
    }
}
