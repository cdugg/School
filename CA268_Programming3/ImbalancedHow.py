def rotation_type(bst, ptr = "root"):
    if ptr == "root":
        ptr = bst.root
    if ptr.left != None:
        return "l" + rotation_type(bst, ptr.left)
    elif ptr.right != None:
        return "r" + rotation_type(bst, ptr.right)
    return ""
