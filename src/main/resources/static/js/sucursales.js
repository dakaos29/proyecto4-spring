$(document).ready(function(){
    cargarDataTable();

});

var dataTable;
function cargarDataTable(){
    dataTable = $('#tablaSucursales').DataTable({
        "ajax": {
            "type" : "GET",
            "datatype" : "json",
            "url" : "/sucursales/api/sucursales"
        },
        "columns" : [{
            "data" : "id",
           "width" : "5%"
            
        }, {
            "data" : "nombre",
            "width" : "20%",
        }, {
            "data" : "direccion",
            "width" : "25%",
            render: function (data, type, row){
		return `${row.direccion.calle} ${row.direccion.numero} ${row.direccion.colonia}`; 
	}
        },{
            "data" : "id",
            "width" : "40%",
            "render" : function(data) {
                return `<div class="text-center"><a class="btn btn-primary" href="/sucursales/edit/${data}">Editar</a>&nbsp; <a class="btn btn-danger text=white" style="cursor:pointer;" onclick="Delete('/sucursales/api/delete/${data}')">Eliminar</a><a class="btn btn-success" href="/sucursales/detalles/${data}">Detalles</a></div>`
            }
        }],
        "language": {
            "decimal" : "",
            "emptyTable" : "no hay informacion",
            "info" : "Mostrando _START_ a _END_ de _TOTAL_ Entradas",
            "infoEmpty" : "Mostrando 0 to 0 of 0 Entradas",
            "infoFiltered" : "(Filtrado de _MAX_ total entradas)",
            "infoPostFix" : "",
            "thousands" : ",",
            "lengthMenu" : "Mostrar _MENU_ Entradas",
            "loadingsRecords" : "Cargando...",
            "Processings" : "Procesando...",
            "search" : "Buscar:",
            "zeroRecords" : "Sin resultados encontrados",
            "paginate" : {
                "first" : "Primero",
                "last" : "Ultimo",
                "next" : "Siguiente",
                "previous" : "Anterior"
            }
        }
    });
}

function Delete(url){
	swal({
		title: "Esta seguro que desea borrar?",
		text: "Este contenido no se puede recuperar",
		type: "warning",
		showCancelButton: true,
		confirmButtonColor: "#DD6B55",
		confirmButtonText: "si, borrar",
		closeOnconfirm: true
	}, function(){
		$.ajax({
			type: 'DELETE',
			url: url,
			success: function(response) {
				if (response.success == "true"){
					toastr.success(response.message);
					dataTable.ajax.reload();
				}
				else{
					toastr.error(response.message);
				}
			}
		});
	});
}