const form = document.querySelector("form")
const botao_adicionar = document.querySelector("#botao_adicionar")

const nome_escola_input = document.querySelector("#nome_escola")
const sexo_input = document.querySelector("#sexo")
const tamanho_input = document.querySelector("#tamanho")
const quantidade_input = document.querySelector("#quantidade")
const uniformes_adicionados_txt = document.querySelector("#uniformes_adicionados")

var uniformes_para_envio = []

function solicitarPedido(){
    fetch("http://localhost:8080",
        {
            method: "POST",
            body: JSON.stringify(uniformes_adicionados_txt.value)
        }
    ).then(function (res) {console.log(res)})
    .catch(function (res) {console.log(res)})

    limpar()
}

function limpar(){
    nome_escola_input.value = "";
    sexo_input.value="";
    tamanho_input.value="";
    quantidade_input.value="";
    uniformes_adicionados_txt.value="";
}

function adicionarPedidoNaLista(){
    var pedido = JSON.stringify(
        {
            nome: nome_escola_input.value,
            sexo: sexo_input.value,
            tamanho: tamanho_input.value,
            quantidade: quantidade_input.value
        })
    uniformes_para_envio.push(pedido)

    uniformes_adicionados_txt.value = uniformes_para_envio;

    sexo_input.value="";
    tamanho_input.value="";
    quantidade_input.value="";
}
