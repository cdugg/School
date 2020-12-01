data Tree a = Null | Node a (Tree a) (Tree a) deriving(Read, Show, Eq)

addNode :: Ord a => a -> Tree a -> Tree a
addNode a Null = (Node a Null Null)
addNode a (Node x xt yt)
   | x > a = Node x (addNode a xt) yt
   | otherwise = Node x xt (addNode a yt)

makeTree :: Ord a => [a] -> Tree a
makeTree [] = Null
makeTree l = betterMakeTree l Null

betterMakeTree :: Ord a => [a] -> Tree a -> Tree a
betterMakeTree [] a = a
betterMakeTree l a = betterMakeTree (init l) (addNode (last l) a)

inOrder :: Eq a => Tree a -> [a]
inOrder Null = []
inOrder (Node x xt yt)
   | xt == Null && yt == Null = [x]
   | xt == Null = [x] ++ inOrder yt
   | yt == Null = inOrder xt ++ [x]
   | otherwise = inOrder xt ++ [x] ++ inOrder yt