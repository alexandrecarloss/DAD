# DAD
Disciplina de Desenvolvimento de Aplicações Distribuidas

# Atividade chat com RMI
Discente: Carlos Alexandre Souza

Relatório Reflexivo - Prática com RMI

1. Experiência com RMI

Como foi sua experiência ao implementar e testar os exercícios?
A implementação dos exercícios com RMI foi uma experiência enriquecedora. Inicialmente, tive alguma dificuldade em entender a arquitetura distribuída, mas à medida que implementava o chat básico e depois o sistema de autenticação, consegui compreender melhor os conceitos. A possibilidade de ter múltiplos clientes se comunicando através de um servidor central foi particularmente interessante.

O que você aprendeu sobre RMI ao longo desta prática?
Aprendi que o RMI fornece uma abstração poderosa para comunicação entre objetos em diferentes JVMs. Aprendi sobre:
- Registro RMI e como os serviços são publicados
- A importância da serialização em chamadas remotas
- Sincronização em ambientes concorrentes
- Tratamento de exceções em chamadas remotas
- Autenticação em sistemas distribuídos

2. Dificuldades Enfrentadas

Quais foram os maiores desafios ou dificuldades durante a implementação?
- **Sincronização**: Garantir que múltiplos clientes não corrompessem a lista de mensagens
- **Autenticação**: Implementar um sistema seguro sem expor senhas

Como você resolveu esses problemas?
- Implementei um mapa de usuários autenticados no servidor

3. Vantagens e Desvantagens

Compare o uso de RMI com outras soluções que você já utilizou:
**Comparação com Web Services:**
- **Vantagens**: Melhor performance, mais simples para Java-to-Java
- **Desvantagens**: Menor interoperabilidade, não é cross-platform

4. Aplicabilidade

Em quais cenários você acredita que o RMI é mais útil?
- Sistemas empresariais onde todos os componentes são em Java
- Aplicações de alto desempenho que requerem comunicação eficiente
- Sistemas onde a simplicidade de implementação é importante

Há cenários em que seria preferível usar outra tecnologia? Por quê?
Sim, em sistemas heterogêneos com múltiplas linguagens, Web Services REST seriam melhores. Para aplicações web, APIs REST são mais adequadas devido à interoperabilidade.

Conclusão
O RMI mostrou-se uma tecnologia poderosa para sistemas distribuídos em Java, oferecendo boa performance e simplicidade de uso, mas com limitações em ambientes heterogêneos.

