#### Finds the largest palindrome made from two 3-digit numbers

def solve_me(obj, *args)
  result = doLessEngineering
  puts result
end

def doStraightImmediately # S.I
  products = 
    (101..999).map{ |a|
      (500..999).map{ |b|
        a*b
      }
    }.flatten.select{ |p|
      p.to_s == p.to_s.reverse
    }.sort.reverse

  return products[0]
end

def doMorePragmatic # M.P
  return doStraightImmediately
end

def doLessEngineering # L.E
  return doMorePragmatic
end
