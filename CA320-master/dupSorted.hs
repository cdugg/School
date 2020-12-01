dupSorted :: Eq a => [a] -> Bool
dupSorted a
   | a == [] = False
   | length a == 1 = False
   | head a == head (tail a) = True
   | otherwise = dupSorted (tail a)