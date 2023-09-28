/*
Definição da classe enumerada dos níveis das formações 
*/
enum class Nivel {BASICO, INTERMEDIARIO, DIFICIL}

/*
Definição da classe de dados de usuários com parâmetros pertinentes ao contexto
*/
data class Usuario(val nome: String, val e_mail: String)

/*
Definição da classe de dados dos conteúdos de cada formação com parâmetros pertinentes ao contexto
*/
data class ConteudoEducacional(var nome: String, var duracao: Int, var descricao: String)

/*
Definição da classe de dados das formações com parâmetros pertinentes ao contexto
*/
data class Formacao(val nome: String, val nivel: Nivel, val conteudos: MutableList<ConteudoEducacional> = 
        mutableListOf()) {

    val inscritos = mutableListOf<Usuario>() // Variável para guardar a lista de usuários inscritos
    
    /*
    Definição da função relacionada às matrículas de cada usuário com parâmetros pertinentes ao contexto
    */
    fun matricular(usuario: Usuario) {

        inscritos.add(usuario) // Inscrição de usuário à uma formação

        println("\nUsuário ${usuario.nome} matriculado na formação $nome") // Coloca na tela nome do usuário
        // e a formação na qual foi inscrito

    }

    /*
    Definição da função relacionada à inserção de um conteúdo educacional numa formação 
    */
    fun inserirConteudo(conteudo: ConteudoEducacional) {
    
        conteudos.add(conteudo) // inserção de um conteúdo educacional

        println("\nConteúdo ${conteudo.nome} inserido na formação $nome") // Coloca na tela o nome do 
        // conteúdo educacional inserido e o nome da formação relacionada

    }

    /*
    Definição da função relacionada à remoçao de um conteúdo educacional numa formação
    */
    fun removerConteudo(conteudo: ConteudoEducacional) {

        conteudos.remove(conteudo) // Remoção de um conteúdo educacional

        println("\nConteúdo ${conteudo.nome} removido da formação $nome") // Imprime na tela o nome do 
        // conteúdo educacional removido e o nome da formação relacionada

    }

    /*
    Definição da função relacionada à visualização dos detalhes da formação
    */
    fun detalhesFormacao() {
    
        println("\nFormação: $nome") // coloca na tela o nome da formação
        println("Nível: $nivel") // Coloca na tela o nível desta formação
        println("Conteúdos: ") // Coloca na tela a palavra apresentada

        var item = 1 // Inicializa uma variável (item) com o valor apresentado

        /*
        Definição do percurso aos conteúdos presentes na formação relacionada
        */
        for(conteudo in conteudos) {

            // Imprime na tela as informações de cada conteúdo
            println("$item. ${conteudo.nome} -> ${conteudo.duracao} horas -> ${conteudo.descricao}") 
            
            item ++ // Passa para o próximo conteúdo da formação para posterior exibição dos seus detalhes
        }

        println("Inscritos: ") // Coloca na tela a palavra apresentada

        /*
        Definição do percurso aos inscritos presentes na formação relacionada
        */
        for(inscrito in inscritos) {
        
            println("$item. ${inscrito.nome} -> ${inscrito.e_mail}") // Coloca na tela as informações de 
            // cada inscrito na formação

            item ++ // Passa para o próximo conteúdo da formação para posterior exibição dos seus detalhes
        }
    }
}

/*
Definição da função de execução do programa 
*/
fun main() {

    // Preenchimento das informações dos usuários como exemplo
    val usuario1 = Usuario("natan", "natanbmn@gmail.com") 
    val usuario2 = Usuario("pedro", "pedron@yahoo.com")

    // Preenchimento das informações dos conteúdos educacionais a considerar numa formação como exemplo
    val conteudo1 = ConteudoEducacional("Introdução ao Git e ao Github", 2, "Conhecimentos Básicos das ferramentas")
    val conteudo2 = ConteudoEducacional("Introdução ao Kotlin", 6, "Utilização básica da linguagem kotlin")

    // preenchimento das informações da formação, e adicionamento dos conteúdos educacionais, das 
    // matrículas desses usuários e dos detalhes dessa formação
    val formacao = Formacao("Desenvolvedor Kotlin Júnior", Nivel.BASICO)
    formacao.inserirConteudo(conteudo1)
    formacao.inserirConteudo(conteudo2)
    formacao.matricular(usuario1)
    formacao.matricular(usuario2)
    formacao.detalhesFormacao()
    
}
