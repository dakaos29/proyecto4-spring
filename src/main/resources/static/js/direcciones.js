$(document).ready(function(){
    cargarDataTable();

});

var dataTable;
function cargarDataTable(){
    dataTable = $('#tablaDirecciones').DataTable({
        "ajax": {
            "type" : "GET",
            "datatype" : "json",
            "url" : "/direcciones/api/listadoDirecciones"
        },
        "columns" : [{
            "data" : "id",
            "width" : "5%"
            
        }, {
            "data" : "calle",
            "width" : "35%"
        }, {
            "data" : "colonia",
            "width" : "30%"
        },{
            "data" : "id",
            "width" : "30%",
            "render" : function(data) {
  return `<div class="text-center">
<a class="btn btn-primary mx-5" href="/direcciones/edit/${data}">Editar</a>&nbsp; 
<a class="btn btn-danger mx-5 text=white" style="cursor:pointer;" onclick="Delete('/direcciones/api/delete/${data}')">Eliminar</a>
<a class="btn btn-success mx-5" href="/direcciones/detalles/${data}">Detalles</a></div>`
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