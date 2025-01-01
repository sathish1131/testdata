$(document).on("click", "#add", function(){
	$("#add-name-input").val("");
	$("#add-data-input").val("");
});

$(document).on("click", "#edit", function(){
	const row = $(this).closest("tr");
	const td = $(this).closest("td");
	const id = td.data("id");
	const name = row.find("td:nth-child(1)").text();
	const data = row.find("td:nth-child(2)").text();
	$("#edit-name-input").val(name);
	$("#edit-data-input").val(data);
	$("#edit-id").val(id);
});

$(document).on("click", "#delete", function(){
	const td = $(this).closest("td");
	const id = td.data("id");
	$("#delete-id").val(id);
});

function showToast(message){
	$("#toast-text").text(message);
	$("#toast").addClass("toast-show").show();

	setTimeout(function(){
		$("#toast").addClass("toast-hide");
	}, 3000);

	setTimeout(function(){
		$("#toast").removeClass("toast-show toast-hide").hide();
	}, 4000);
}

$(document).on("click", "#confirm-delete", function(){
	const id = $("#delete-id").val();
	$.ajax({
		url: `/delete-data/${id}`,
		type: "DELETE",
		success: function(response){
			$("#deleteModal").modal("hide");
			$(`td[data-id='${id}']`).closest("tr").remove();
			showToast("Testdata Deleted Successfully");
		},
		error: function(err){
			$("#deleteModal").modal("hide");
			showToast("Something went wrong. Please try again later...");
		}
	})
});

$(document).on("submit", "#addDataForm", function(e){
	e.preventDefault();
	const name = $("#add-name-input").val().trim();
	const data = $("#add-data-input").val().trim();
	$.ajax({
		url: `/add-data`,
		contentType: "application/json",
		type: "POST",
		data: JSON.stringify({
			name: name,
			data: data,
		}),
		success: function(response){
			$("#addModal").modal("hide");
			$("#data-table").replaceWith($(response).find("#data-table"));
			showToast("Testdata Added Successfully");
		},
		error: function(err){
			$("#addModal").modal("hide");
			showToast("Something went wrong. Please try again later...");
		}
	})
});

$(document).on("submit", "#editDataForm", function(e){
	e.preventDefault();
	const id = $("#edit-id").val();
	const name = $("#edit-name-input").val().trim();
	const data = $("#edit-data-input").val().trim();
	showToast("User Deleted Successfully");
	$.ajax({
		url: `/update-data/${id}`,
		type: "POST",
		contentType: "application/json",
		data: JSON.stringify({
			name: name,
			data: data,
		}),
		success: function(response){
			$("#editModal").modal("hide");
			$("#data-table").replaceWith($(response).find("#data-table"));
			showToast("Testdata Updated Successfully");
		},
		error: function(err){
			$("#editModal").modal("hide");
			showToast("Something went wrong. Please try again later...");
		}
	})
});

