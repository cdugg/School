import Data.Char(toUpper)
import Data.Char(isAlpha)
stringToUpper :: String -> String
stringToUpper s
   | length s == 1 && isAlpha(head s) = [toUpper(head s)]
   | length s == 1 = [head s]
   | isAlpha(head s) = toUpper(head s):stringToUpper(tail s)
   | otherwise = (head s):stringToUpper(tail s)