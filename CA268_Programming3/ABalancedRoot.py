def is_avl(bst):
    root = bst.root
    bst.root = bst.root.left
    l = bst.height()
    bst.root = root
    bst.root = bst.root.right
    r = bst.height()
    if l > r + 1 or r > l + 1:
        return False
    else:
        return True
