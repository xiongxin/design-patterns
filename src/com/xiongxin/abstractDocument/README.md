## Intent

在保持类型安全的情况下，使用动态属性和完成灵活的无类型语言

## Explanation

抽象文档模式开启捕获额外，非静态属性。这个模式使用traits的概念确保类型安全将不同类型的属性分散在接口中。

### Real word example

考虑汽车包含多个不同的部分。我们不知道特定的车会有那些不同的部分，或者仅仅有一部分。我们的车是动态，特别灵活的。

### In plain words

抽象文档模式允许附加属性到对象时而不太清楚有那些属性。