var baseUrl = "http://localhost:8080/registros";
function carregarItens() {
    var url = baseUrl + "/"
    $.ajax({
        type: "GET",
        url: url,
        timeout: 3000,
        datatype: 'JSON',
        contentType: "application/json; charset=utf-8",
        cache: false,
        beforeSend: function () {
            //
        },
        error: function () {
            //
        },
        success: function (retorno) {
            var registros = retorno;
            $.each(registros, function (i, registro) {
                var columns = '<td>' + registro.id + '</td>'
                columns += '<td>' + registro.dataTime + '</td>'
                columns += '<td>' + registro.mate + '</td>'
                columns += '<td>' + registro.total_weight + '</td>'
                columns += '<td>' + registro.axle_number + '</td>'
                columns += '<td>' + registro.overloaded + '</td>'
                columns += '<td>' + registro.formFactor + '</td>'
                var tr = '<tr onclick="carregarItem(' + registro.id + ')">' + columns + '</tr>';
                $('#tbregistros tbody').after(tr);
                console.log(registro);
            });
        }
    });
}

function carregarItem(id) {
    console.log(id);
    var url = baseUrl + "/" + id
    $.ajax({
        type: "GET",
        url: url,
        timeout: 3000,
        datatype: 'JSON',
        contentType: "application/json; charset=utf-8",
        cache: false,
        beforeSend: function () {
            //
        },
        error: function () {
            //
        },
        success: function (retorno) {
            var registro = retorno;
            console.log(registro);
            $("#dthora").text(registro.dataTime);
            $("#peso").text(registro.total_weight);
            $("#placa").text(registro.mate);
            carregarImagem(registro.sanpshot1);
            $('#modalOpen').modal('open');

        }
    });
}
function carregarImagem(filePath) {
    console.log(filePath);
    var url = baseUrl + "/getImage/" + filePath
    $.ajax({
        type: "GET",
        url: url,
        timeout: 3000,
        datatype: 'JSON',
        contentType: "application/json; charset=utf-8",
        cache: false,
        beforeSend: function () {
            //
        },
        error: function () {
            //
        },
        success: function (retorno) {
            var imagem = retorno;
            $("#img").attr('src','data:image/jpg;base64,' + imagem);
        }
    });





}