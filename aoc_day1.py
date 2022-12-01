l=list()
ans=0
while(True):
    try:
        n=input()
        if(len(n)!=0):
            ans=ans+int(n)
        else:
            l.append(ans)
            ans=0
    except EOFError:
        l.sort(reverse=True)
        sol,i=0,0
        while(i<3 and i<len(l)):
            sol+=l[i]
            i+=1
        print(sol)
        break
    
    
