#### Finds the sum of (unique) multiples of 3 or 5 in first 1000 numbers

def solve_me(obj, *args)
  sum = doLessEngineering
  puts sum
end

def doStraightImmediately # S.I
  sum = 0

  1000.times { |n|
    sum += n if n % 3 == 0 || n % 5 == 0
  }
  return sum
end

def doMorePragmatic # M.P
  return doStraightImmediately
end

def doLessEngineering # L.E
  return doMorePragmatic
end
