numSorted :: Ord a => a -> [a] -> Int
numSorted a b
   | b == [] = 0
   | head b > a = 0
   | head b == a = 1 + numSorted a (tail b)
   | otherwise = numSorted a (tail b)