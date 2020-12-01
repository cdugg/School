elemSorted :: Ord a => a -> [a] -> Bool
elemSorted a b
   | b == [] = False
   | head b > a = False
   | head b == a = True
   | otherwise = elemSorted a tail b