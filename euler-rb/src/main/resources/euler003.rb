#### Finds the largest prime factor of 600 851 475 143

def solve_me(obj, *args)
  result = doLessEngineering
  puts result
end

def doStraightImmediately # S.I
  max = 600_851_475_143
  factor = 2

  max % factor == 0 ? max /= factor : factor += 1  while max > 1
  return factor
end

def doMorePragmatic # M.P
  return doStraightImmediately
end

def doLessEngineering # L.E
  return doMorePragmatic
end
