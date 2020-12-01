data Tree a = Null | Node a (Tree a) (Tree a) deriving(Read, Show, Eq)

addNode :: Ord a => a -> Tree a -> Tree a
addNode a Null = (Node a Null Null)
addNode a (Node x xt yt)
   | x > a = Node x (addNode a xt) yt
   | otherwise = Node x xt (addNode a yt)