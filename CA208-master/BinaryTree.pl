%Empty
emptyBT(tree(nil)).

%Validate Tree
binaryTree(nil).
binaryTree(tree(X, Left, Right)) :- rightSmaller(X, Right), leftBigger(X, Left), binaryTree(Left), binaryTree(Right).
rightSmaller(_, nil).
rightSmaller(X, tree(Y, _, _)) :- Y > X.
leftBigger(_, nil).
leftBigger(X, tree(Y, _, _)) :- Y =< X.

%Insert
insert(X, nil, tree(X, nil, nil)).
insert(I, tree(X, Y, Z), tree(X, Y2, Z)) :- I =< X, insert(I, Y, Y2).
insert(I, tree(X, Y, Z), tree(X, Y, Z2)) :- insert(I, Z, Z2).

%Check predicate to be reused in all order predicates
checkpos(X) :- b_getval('Copy', [Head | Tail]), Head is X, b_setval('Copy', Tail).

%Preorder
preorder(nil, L) :- L \= [], !, fail.
preorder(T, L) :- binaryTree(T), b_setval('Copy', L), preorderPart2(T).
preorderPart2(nil).
preorderPart2(tree(X, L, R)) :- checkpos(X), preorderPart2(L), preorderPart2(R).

%In Order
inorder(nil, L) :- L \= [], !, fail.
inorder(T, L) :- binaryTree(T), b_setval('Copy', L), inorderPart2(T).
inorderPart2(nil).
inorderPart2(tree(X, L, R)) :- inorderPart2(L), checkpos(X), inorderPart2(R).

%Postorder
postorder(nil, L) :- L \= [], !, fail.
postorder(T, L) :- binaryTree(T), b_setval('Copy', L), postorderPart2(T).
postorderPart2(nil).
postorderPart2(tree(X, L, R)) :- postorderPart2(L), postorderPart2(R), checkpos(X).

%Search
search(T, N) :- binaryTree(T), search2(T, N).
search2(tree(Node, _, _), Node).
search2(tree(Node, L, _), N) :- N =< Node, search(L, N).
search2(tree(_, _, R), N) :- search(R, N).

%Height
height(nil, 0).
height(tree(_, R, L), X) :- height(L, Leftheight), height(R, Rightheight), X is max(Leftheight, Rightheight)+1.
