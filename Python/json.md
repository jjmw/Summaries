# JSON

```python
class Employee(object):
def __init__(self,name1, name2):
self.name1 = name1
self.name2 = name2
def toJSON(self):
return json.dumps(self, default=lambda o: o.__dict__, 
sort_keys=True, indent=4)


ader = Employee('Olifant', 'aap')
json.loads(ader.toJSON())['name2']
```
