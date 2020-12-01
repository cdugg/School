data Month = Jan | Feb | Mar | Apr | May | Jun | Jul | Aug | Sep | Oct | Nov | Dec deriving (Eq, Enum, Read, Show)

data Day = Sunday | Monday | Tuesday | Wednesday | Thursday | Friday | Saturday deriving (Eq, Enum, Ord, Show)

type Monthday = Int
type Year = Int
type Date = (Monthday, Month, Year)

numDays :: Date -> Int
numDays (day, month, year)
   | year > 1753 = sum(mLengths year) + numDays (day, month, year - 1)
   | month == Jan = day
   | month == Feb = day + 31
   | month == Mar = day + sum([31,28])
   | month == Apr = day + sum([31,28,31])
   | month == May = day + sum([31,28,31,30])
   | month == Jun = day + sum([31,28,31,30,31])
   | month == Jul = day + sum([31,28,31,30,31,30])
   | month == Aug = day + sum([31,28,31,30,31,30,31])
   | month == Sep = day + sum([31,28,31,30,31,30,31,31])
   | month == Oct = day + sum([31,28,31,30,31,30,31,31,30])
   | month == Nov = day + sum([31,28,31,30,31,30,31,31,30,31])
   | otherwise = day + sum([31,28,31,30,31,30,31,31,30,31,30])

mLengths :: Int -> [Int]
mLengths x
   | leap x == True = [31,29,31,30,31,30,31,31,30,31,30,31]
   | otherwise = [31,28,31,30,31,30,31,31,30,31,30,31]

leap :: Int -> Bool
leap a
   | mod a 4 == 0 && mod a 100 /= 0 = True
   | mod a 400 == 0 = True
   | otherwise = False