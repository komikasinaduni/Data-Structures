public class DS5_BinarySearchTree<E extends Comparable> implements DS5_BinarySearchTree_Interface<E> {
    private DS5_BinarySearchTree_Node<E> root;
    private boolean insert;
    private boolean remove;

    public DS5_BinarySearchTree(){
        root = new DS5_BinarySearchTree_Node<>(null);
    }

    public DS5_BinarySearchTree(E data){
        root = new DS5_BinarySearchTree_Node<>(data);
    }
    @Override
    public DS5_BinarySearchTree_Node<E> getRoot() {
        return root;
    }

    @Override
    public String preOrder() {
        if(root==null)
            return "[]";
        return "["+preOrderHelper(root).substring(2)+"]";
    }

    public String preOrderHelper(DS5_BinarySearchTree_Node<E> temp) {
        if(temp==null)
            return "";
        else
            return ", "+temp.getData() + preOrderHelper(temp.getLeft()) + preOrderHelper(temp.getRight());
    }

    @Override
    public String inOrder() {
        if(root==null)
            return "[]";
        return "["+inOrderHelper(root).substring(2)+"]";
    }

    public String inOrderHelper(DS5_BinarySearchTree_Node<E> temp){
        if(temp==null)
            return "";
        else
            return ", " +  inOrderHelper(temp.getLeft()) + temp.getData() + inOrderHelper(temp.getRight());
    }

    @Override
    public String postOrder() {
        if(root==null)
            return "[]";
        return "["+postOrderHelper(root).substring(2)+"]";
    }

    public String postOrderHelper(DS5_BinarySearchTree_Node<E> temp){
        if(temp==null)
            return "";
        else
            return ", " + inOrderHelper(temp.getLeft()) + inOrderHelper(temp.getRight()) + temp.getData();
    }

    @Override
    public E minValue() {
        if(root==null){
            return null;
        } else{
            DS5_BinarySearchTree_Node<E> yo = root;
            while(yo.getLeft()!=null){
                yo = yo.getLeft();
            }
            return yo.getData();
        }
    }

    @Override
    public E maxValue() {
        return maxValueHelper(root);
    }

    public E maxValueHelper(DS5_BinarySearchTree_Node<E> wow){
        if(wow.getRight()==null){
            return wow.getData();
        }
        return maxValueHelper(wow.getRight());
    }

    @Override
    public int nodeDepth(E value) {
        return nodeDepthHelper(root, new DS5_BinarySearchTree_Node<E>(value), 0);
    }

    public int nodeDepthHelper(DS5_BinarySearchTree_Node<E> yo, DS5_BinarySearchTree_Node<E> target, int cd){
        if(yo==null){
            return -1;
        }
        if(yo==target){
            return cd;
        }
        int ld = nodeDepthHelper(yo.getLeft(), target, cd+1);
        if(ld!=-1){
            return ld;
        }
        int rd = nodeDepthHelper(yo.getRight(), target, cd+1);
        return rd;
    }

    @Override
    public int height() {
        return heightHelper(root);
    }

    public int heightHelper(DS5_BinarySearchTree_Node<E> yo){
        int lh = heightHelper(yo.getLeft());
        int rh = heightHelper(yo.getRight());
        return 1 + Math.max(lh, rh);
    }

    @Override
    public int maxDepth() {
        return height()-1;
    }

    @Override
    public void clear() {
        root = new DS5_BinarySearchTree_Node<>(null);
    }

    @Override
    public int size() {
        return sizeHelper(root);
    }

    public int sizeHelper(DS5_BinarySearchTree_Node<E> wow){
        if(wow==null){
            return 0;
        } else{
            return 1+sizeHelper(wow.getLeft()) + sizeHelper(wow.getRight());
        }
    }

    @Override
    public boolean isEmpty() {
        return size()==0;
    }

    @Override
    public boolean contains(E data) {
        return containsHelper(root, data);
    }

    public boolean containsHelper(DS5_BinarySearchTree_Node<E> yo, E value){
        if(yo==null){
            return false;
        }
        if(value.equals(yo.getData())){
            return true;
        }
        return containsHelper(yo.getLeft(), value) || containsHelper(yo.getRight(), value);

    }

    @Override
    public boolean insert(E data) {
        insert=false;
        root = insertHelper(root, data);
        return insert;
    }

    public DS5_BinarySearchTree_Node<E> insertHelper(DS5_BinarySearchTree_Node<E> wow, E value) {
        if (wow == null) {
            insert = true;
            return new DS5_BinarySearchTree_Node<>(value);
        }
        int comp = value.compareTo(wow.getData());
        if (comp < 0) {
            wow.setLeft(insertHelper(wow.getLeft(), value));
        } else if (comp > 0) {
            wow.setRight(insertHelper(wow.getRight(), value));
        } else {
            return wow;
        }
        return wow;
    }

    @Override
    public boolean remove(E data) {
        remove = false;
        return remove;
    }

    public DS5_BinarySearchTree_Node<E> removeHelper(DS5_BinarySearchTree_Node<E> wow, E value){
        if(wow==null){
            return null;
        }
        int comp = value.compareTo(wow.getData());
        if (comp < 0) {
            wow.setLeft(removeHelper(wow.getLeft(), value));
        } else if (comp > 0) {
            wow.setRight(removeHelper(wow.getRight(), value));
        } else {
            remove = true;
            if(wow.getLeft()==null){
                return wow.getRight();
            } else if(wow.getRight()==null){
                return wow.getLeft();
            }
            DS5_BinarySearchTree_Node<E> wow2;
        }
        return wow;
    }

}
