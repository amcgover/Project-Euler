from fractions import gcd

fractionCount = 0;
fractionNumeratorProduct = 1; 
fractionDenominatorProduct = 1; 
for num in range(10,101):
    for den in range(num+1,101):
        numList = list(str(num))
        denList = list(str(den))
        intersect = [digit for digit in numList if digit in denList];
        if len(intersect) > 0 and intersect[0] != '0':
            numList.remove(intersect[0]);
            denList.remove(intersect[0]);
            
            try:
                if (float(num)/float(den)) == (float(''.join(numList))) / (float(''.join(denList))):
                    fractionCount+=1;
                    fractionNumeratorProduct *= num;
                    fractionDenominatorProduct *= den;
                    print '%d/%d==%s/%s' % (num,den,''.join(numList),''.join(denList))
            except ZeroDivisionError:
                pass;
                
print fractionCount;
greatestCommonDivisor = gcd(fractionNumeratorProduct,fractionDenominatorProduct)
fractionNumeratorProduct /= greatestCommonDivisor;
fractionDenominatorProduct /= greatestCommonDivisor;
print '%d/%d' % (fractionNumeratorProduct,fractionDenominatorProduct)
