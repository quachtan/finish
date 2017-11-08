var CMS = CMS || {};
CMS.Form6 = {};

var currentForm = $("#form_ThayDoi");
var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");

var ThongTinThayDoiTable = null;

CMS.Form6.changeFormType = function(data) {
	if (data.type == 1) {
		$("#FormType").val("1");
		currentForm.attr("formType", "donVi");
		currentForm[0].LIST_TT = CMS.Form6.getListTT();
		CMS.Form6.hideAllForm();
		CMS.Form6.displayFormDonVi(data.donVi);
	} else if (data.type == 2) {
		$("#FormType").val("2");
		currentForm.attr("formType", "duAn");
		currentForm[0].LIST_TT = CMS.Form6.getListTT();
		CMS.Form6.hideAllForm();
		CMS.Form6.displayFormDuAn(data.duAn);
	} else {
		$("#FormType").val("");
		currentForm.attr("formType", "");
		currentForm[0].LIST_TT = [];
		CMS.Form6.hideAllForm();
	}

	ThongTinThayDoiTable.clearTable();

}

CMS.Form6.getListTT = function() {
	var results;
	$.ajax({
		url : currentForm[0].infoCheckListUrl,
		dataType : "json",
		type : "GET",
		async : false,
		data : {
			type : currentForm.attr("formType")
		},
		timeout : 5000,
		success : function(data) {
			results = $.map(data, function(item) {
				return {
					text : item.colId + " - " + item.ten,
					id : item.id,
					colName : item.colName
				}
			});
		}
	});
	return results;
}

CMS.Form6.hideAllForm = function() {
	$("#TenDonVi").val("");
	$("#TinhThanhChuDauTu").val("");
	$("#HuyenChuDauTu").val("");
	$("#XaChuDauTu").val("");
	$("#DiaChiCDT").val("");
	$("#DienThoaiCDT").val("");
	$("#EmailCDT").val("");
};

CMS.Form6.displayFormDonVi = function(result) {
	$("#TenDonVi").val(result.ten);
	$("#TinhThanhChuDauTu").val(result.tinh);
	$("#HuyenChuDauTu").val(result.huyen);
	$("#XaChuDauTu").val(result.xa);
	$("#DiaChiCDT").val(result.diaChi);
	$("#DienThoaiCDT").val("");
	$("#EmailCDT").val("");

};

CMS.Form6.displayFormDuAn = function(result) {
	$("#TenDonVi").val(result.tenDuAn);
	if (result.chuDauTu) {
		$("#TinhThanhChuDauTu").val(result.chuDauTu.tinh);
		$("#HuyenChuDauTu").val(result.chuDauTu.huyen);
		$("#XaChuDauTu").val(result.chuDauTu.xa);
		$("#DiaChiCDT").val(result.chuDauTu.diaChi);
	}
	$("#DienThoaiCDT").val("");
	$("#EmailCDT").val("");
};

CMS.Form6.findThongTinCu = function(maDv, truongHtId, el) {
	$.ajax({
		url : currentForm[0].infoCheckFieldUrl,
		dataType : "text",
		type : "GET",
		data : {
			type : currentForm.attr("formType"),
			maDv : maDv,
			truongHTId : truongHtId,
		},
		timeout : 5000,
		success : function(data) {
			el.val(data);
		},
		error : function() {
			el.val("Không tìm thấy dữ liệu!");
		}
	});
};

// Tao danh muc
CMS.DM.createDMList_LoaiHDV();
CMS.DM.createDMList_LoaiCP();
CMS.DM.createDMList_ChuongNganSach();
CMS.DM.createDMList_CapDuToan();
CMS.DM.createDMList_NhomDA();
CMS.DM.createDMList_HinhThucDuAn();
CMS.DM.createDMList_HinhThucQuanLy();
CMS.DM.createDMList_NganhKT();
var funcMap = {
	'LHDV_ID' : function(row, input) {
		input.select2(
				{
					placeholder : "Lựa chọn",
					language : "vi",
					query : function(query) {
						CMSCommonJs.Select2.queryArray(CMS.DM.List.LoaiHDV,
								query);
					},
					initSelection : function(element, callback) {
						CMSCommonJs.Select2.initSelectionArray(
								CMS.DM.List.LoaiHDV, element, callback);
					}
				}).on("select2-close", function(e) {
			$(this).valid();
		}).on("select2-selected", function(evt) {
			CMS.Form6.onchangeSelect2(row);
		});
	},
	'DIACHI' : function(row,input)
	{
		input.click(function(e)
				{
			e.preventDefault();
			$("#SelectDiadiem").modal('show');
				}
	);
			$('#btnSave').click(function() {
				var maTinh = $('input[name=TinhThanhDiaDiem]').val();
				var maHuyen = $('input[name=HuyenDiaDiem]').val();
				var maXa = $('input[name=XaDiaDiem]').val();
				var soNha = $("#DiaChi").val();
				var maDb =  maTinh + "-" + maHuyen + "-" + maXa;
				if (maDb) {
					var ajaxUrl = CMSCommonJs.ROOT_URL + 'ajax/danhmuc/diaban/full';
					$.ajax({
						url : ajaxUrl,
						dataType : "json",
						type : "GET",
						data : {
							maDb : maDb
						},
						timeout : 5000,
						success : function(result) {
							if(result!=null)
						{
						row.find("#newValueText").val(maXa);
						if(soNha){
						row.find("#newValue").val(soNha + " , " + result.tenXa+", "+result.tenHuyen +", "  + result.tenTinh);
					}
						else
								{
						row.find("#newValue").val(result.tenXa+", "+result.tenHuyen +", "  + result.tenTinh);	
								}
						}
						}
					});
				}
			    $('#SelectDiadiem').modal('hide');
			  });
	},
	'DVQLTT_ID' : function(row,input)
	{
		input.click(function(e)
				{
			e.preventDefault();
			$("#SelectDVQLTT").modal('show');
			var ma = $('#DonViQuanLyCapTrenTrucTiep').val();
			if (ma && ma.length == 7) {
				var ajaxUrl = CMSCommonJs.ROOT_URL + 'ajax/danhmuc/dvsdns';
				if (editable == false) {
					ajaxUrl = ajaxUrl + "/view";
				}
				$.ajax({
					url : ajaxUrl,
					dataType : "json",
					type : "GET",
					data : {
						ma : ma
					},
					success : function(result) {
						if (result != null) {
							$("#TenDonViQuanLyCapTrenTrucTiep").val(result.ten);

						} else {
							$("#TenDonViQuanLyCapTrenTrucTiep").val("");
						}
					}
				});
			}
				}
	);
			$('#btnSave').click(function() {
				row.find("#newValue").val(ma);
				row.find("#newValueText").val(ma);
			    $('#SelectDVQLTT').modal('hide');
			  });
	},
	'CCH_ID' : function(row, input) {
		input.select2(
				{
					placeholder : "Lựa chọn",
					language : "vi",
					query : function(query) {
						CMSCommonJs.Select2.queryArray(
								CMS.DM.List.ChuongNganSach, query);
					},
					initSelection : function(element, callback) {
						CMSCommonJs.Select2.initSelectionArray(
								CMS.DM.List.ChuongNganSach, element, callback);
					}
				}).on("select2-close", function(e) {
			$(this).valid();
		}).on("select2-selected", function(evt) {
			CMS.Form6.onchangeSelect2(row);
		});
	},
	'CAPDT' : function(row, input) {
		input.select2(
				{
					placeholder : "Lựa chọn",
					language : "vi",
					query : function(query) {
						CMSCommonJs.Select2.queryArray(CMS.DM.List.CapDuToan,
								query);
					},
					initSelection : function(element, callback) {
						CMSCommonJs.Select2.initSelectionArray(
								CMS.DM.List.CapDuToan, element, callback);
					}
				}).on("select2-close", function(e) {
			$(this).valid();
		}).on("select2-selected", function(evt) {
			CMS.Form6.onchangeSelect2(row);
		});
	},
	'NHOMDA_ID' : function(row, input) {
		input.select2(
				{
					placeholder : "Lựa chọn",
					language : "vi",
					query : function(query) {
						CMSCommonJs.Select2.queryArray(CMS.DM.List.NhomDA,
								query);
					},
					initSelection : function(element, callback) {
						CMSCommonJs.Select2.initSelectionArray(
								CMS.DM.List.NhomDA, element, callback);
					}
				}).on("select2-close", function(e) {
			$(this).valid();
		}).on("select2-selected", function(evt) {
			CMS.Form6.onchangeSelect2(row);
		});
	},
	'HTDA_ID' : function(row, input) {
		input.select2(
				{
					placeholder : "Lựa chọn",
					language : "vi",
					query : function(query) {
						CMSCommonJs.Select2.queryArray(
								CMS.DM.List.HinhThucDuAn, query);
					},
					initSelection : function(element, callback) {
						CMSCommonJs.Select2.initSelectionArray(
								CMS.DM.List.HinhThucDuAn, element, callback);
					}
				}).on("select2-close", function(e) {
			$(this).valid();
		}).on("select2-selected", function(evt) {
			CMS.Form6.onchangeSelect2(row);
		});
	},
	'NGAY_TL': function (row, input){
		 input.datepicker().mask("00/00/0000");
		 },
	'HTQL_ID' : function(row, input) {
		input.select2(
				{
					placeholder : "Lựa chọn",
					language : "vi",
					query : function(query) {
						CMSCommonJs.Select2.queryArray(
								CMS.DM.List.HinhThucQuanLy, query);
					},
					initSelection : function(element, callback) {
						CMSCommonJs.Select2.initSelectionArray(
								CMS.DM.List.HinhThucDuAn, element, callback);
					}
				}).on("select2-close", function(e) {
			$(this).valid();
		}).on("select2-selected", function(evt) {
			CMS.Form6.onchangeSelect2(row);
		});
	},
// ,
// 'NGANH_KINH_TE': function (row, input){
// input.select2({
// placeholder : "Lựa chọn",
// language : "vi",
// query : function(query) {
// CMSCommonJs.Select2.queryArray(CMS.DM.List.NganhKT, query);
// },
// initSelection : function(element, callback) {
// CMSCommonJs.Select2.initSelectionArray(
// CMS.DM.List.NganhKT, element, callback);
// }
// }).on("select2-close", function(e) {
// $(this).valid();
// }).on("select2-selected",function(evt) {
// CMS.Form6.onchangeSelect2(row);
// });
// },
 'NGAY_BD': function (row, input){
 input.datepicker().mask("00/00/0000");
 },
 'NGAY_KT': function (row, input){
 input.datepicker().mask("00/00/0000");
 },
 'NGAY_QD': function (row, input){
 input.datepicker().mask("00/00/0000");
 }
// 'NGUOI_KY_QD': function (row, input){
// input.datepicker().mask("00/00/0000");
// },
// 'DIA_DIEM': function (row, input){
// }
}
CMS.Form6.changeInput = function(row, colName) {
	var rowIndex = row.attr("rowid");
	row.find("#tdNewValue").empty();
	row
			.find("#tdNewValue")
			.append(
					"<input name='listThayDoi["
							+ rowIndex
							+ "].thongTinMoi' id='newValue' type='text' style='width:200px' required = 'true'/>");
	if (funcMap[colName]) {
		var input = row.find("#newValue");
		funcMap[colName](row, input);
	}
};

CMS.Form6.onchangeSelect2 = function(row) {
	var newValueText = row.find("#newValue").select2('data').text;
	row.find("#newValueText").val(newValueText);
};

$(function() {
	// Create send dialog
	$("#ValidateDialog").dialog({
		resizable : false,
		autoOpen : false,
		width : 400,
		height : 200,
		modal : true,
		buttons : {
			"Huỷ" : function() {
				$(this).dialog("close");
			}
		}
	});
	
	$("#SendDialog").dialog({
		resizable : false,
		autoOpen : false,
		width : 400,
		height : 200,
		modal : true,
		buttons : {
			"Gửi" : function() {
				$(this).dialog("close");
				currentForm.submit();
			},
			"Huỷ" : function() {
				$(this).dialog("close");
			}
		}
	});
	/*$("#SelectDiadiem").dialog({
		resizable : false,
		autoOpen : false,
		width : 660,
		height : 400,
		modal : true,
		buttons : {
			"Nhập" : function() {
			var tinh = document.getElementById("TinhThanhDiaDiem");
			$(this).alert("ukm");
			$("#newValue").val(tinh.value);
			$(this).dialog("close");
			}
		}
	});*/
	
	var isEditable = currentForm.attr("formMode") == "create"
			|| currentForm.attr("formMode") == "edit";
	var isHasData = currentForm.attr("formMode") == "view"
			|| currentForm.attr("formMode") == "edit";

	CMSCommonJs.Form.addGaleryDisplay2([ {
		fileInput : "#FileDinhKem1",
		hiddenInput : "#url1",
	}, {
		fileInput : "#FileDinhKem2",
		hiddenInput : "#url2",
	}, ], isEditable);
	if (isEditable) {
		editable = true;
		CMSCommonJs.Form.addFormFileValidation(currentForm,
				" input[name='file1']", isEditable);
		CMSCommonJs.Form.addFormFileValidation(currentForm,
				" input[name='file2']" );
		CMSCommonJs.Form.addFormSubmitDialogCheck(currentForm, "#btnGui", "#btnGui",
				"#SendDialog");
	} else {

	}
	ThongTinThayDoiTable = new SimpleFormTable({
		$el : $("#ThongTinThayDoiList"),
		$template : $.templates("#ThongTinThayDoiRow"),
		createRowData : function(row) {
			var input = row.find("#TruongThongTin");
			input.select2(
					{
						placeholder : "Lựa chọn",
						language : "vi",
						query : function(query) {
							CMSCommonJs.Select2.queryArray(
									currentForm[0].LIST_TT, query);
						},
						initSelection : function(element, callback) {
							CMSCommonJs.Select2.initSelectionArray(
									currentForm[0].LIST_TT, element, callback);
						}
					}).on(
					"select2-selected",
					function(evt) {
						row.find("#oldValue").val("Đang tìm thông tin cũ");

						CMS.Form6.findThongTinCu($("#maDv").val(), row.find(
								"#TruongThongTin").select2('val'), row
								.find("#oldValue"));

						var truongId = row.find("#TruongThongTin").select2(
								'val');
						var colName = $.grep(currentForm[0].LIST_TT, function(
								entry, index) {
							return entry.id == truongId;
						})[0];

						CMS.Form6.changeInput(row, colName.colName);
					});
		},
	});
	
	ThongTinThayDoiTable.clearTable();
	currentForm[0].LIST_TT = CMS.Form6.getListTT();
	
	$("#btnGui").click(function(evt) {
		evt.preventDefault();
		var tenDv = document.getElementById("newValue");
		if (byteLength(tenDv.value) > 240)
			{
			alert("Tên trường nhập tối đa 240 ký tự");
			setTimeout(function(){tenDv.focus();}, 1);
			}
		else if (ThongTinThayDoiTable.getNumRow() == 0) {
			$("#ValidateDialog").dialog("open");
		} else {
			$("#SendDialog").dialog("open");
		}
	});
	CMSCommonJs.Form.createDiaDiemList(isEditable, '#TinhThanhDiaDiem',"#HuyenDiaDiem", "#XaDiaDiem");
	$("#resetEditForm").click(function(evt) {
		evt.preventDefault();
		ThongTinThayDoiTable.clearTable();
	});
	$("#resetCreateForm").click(function(evt) {
		ThongTinThayDoiTable.clearTable();
	});

});
function byteLength(str) {
	  // returns the byte length of an utf8 string
	  var s = str.length;
	  for (var i=str.length-1; i>=0; i--) {
	    var code = str.charCodeAt(i);
	    if (code > 0x7f && code <= 0x7ff) s++;
	    else if (code > 0x7ff && code <= 0xffff) s+=2;
	    if (code >= 0xDC00 && code <= 0xDFFF) i--; //trail surrogate
	  }
	  return s;
	}