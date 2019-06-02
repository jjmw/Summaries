Class

```python
import attr

@attr.s(auto_attribs=True)
class Book(object):
    isbn: str
    name: str
    author: str
    published_year: int
    edition: int
```