/**
 * 
 */

$(document)
		.ready(
				function() {

					$('#fetchNumbers')
							.click(
									function() {
										alert();
										console.log("In ajax");
/*
										var table = document
												.getElementById("addValue");
										var row = table.insertRow(1);
										var cell1 = row.insertCell(0);
										var cell2 = row.insertCell(1);

										var stockGroupForm = {}
										// Here "groupName" is mapped with
										// entity name
										stockGroupForm["groupName"] = $(
												"#stockGroupName").val();
										var JsonItem = JSON
												.stringify(stockGroupForm);*/
										console.log(JsonItem);
										$
												.ajax({
													url : "/stockgroupsave",
													type : "POST",
													contentType : 'application/json; charset=utf-8',
													dataType : 'json',
													data : JsonItem,

													success : function(result) {
														console
																.log(result.groupName);
														var all = result.groupName;

														/* $("#postResultDivv").append(result.groupName); */

														/*
														 * $("#addValue").find("tr").last("td").css({"color":
														 * "red", "border": "2px
														 * solid red"});
														 * cell1.innerHTML =
														 * result.stockGroupId;
														 * cell2.innerHTML =
														 * result.groupName;
														 */
												/*		var button = '<button class="btn glyphicon glyphicon-edit">'
																+ this
																+ '</button>&nbsp;';

														$('#addValue')
																.append(
																		'<tr><td>'
																				+ result.stockGroupId
																				+ '</td><td>'
																				+ result.groupName
																				+ '</td><td>'
																				+ button
																				+ '</td></tr>');*/

													}

												});

									});
					
					
					
					
					
					

					$('#itemSave').click(function() {
						console.log("In ajax");

						var stockItemForm = {
							'stockGroupName' : {
								'groupName' : $("#stockGroupNameForItem").val()

							},
							'itemName' : $("#itemName").val(),
							'unit' : $("#unit").val(),
							'openQuantity' : $("#openquantity").val(),
							'rate' : $("#rate").val(),
							'amount' : $("#amount").val()

						};

						var JsonItem = JSON.stringify(stockItemForm);
						console.log(JsonItem);
						$.ajax({
							url : "/stockgroupitemsave",
							type : "POST",
							contentType : 'application/json; charset=utf-8',
							dataType : 'json',
							data : JsonItem,

							success : function(result) {

								console.log(result.itemName);

								$("#postResultDiv").append(result.itemName);

							}

						});

					});

					/** add active class and stay opened when selected */
					var url = window.location;

					// for sidebar menu entirely but not cover treeview
					$('ul.sidebar-menu a').filter(function() {
						return this.href == url;
					}).parent().addClass('active');

					// for treeview
					$('ul.treeview-menu a').filter(function() {
						return this.href == url;
					}).parentsUntil(".sidebar-menu > .treeview-menu").addClass(
							'active');

					$('#btn_login_details')
							.click(
									function() {

										var nameValidation = document
												.getElementById("stdName").value;

										var classValidation=document
										.getElementById("coachingClassId").value;
										
										
										
										if (classValidation =="" ||classValidation==null ) {
											var ox = "** Class is required";

											document
													.getElementById("classValidationField").innerHTML = ox;
											document
													.getElementById("classValidationField").style.color = "red";
											return false;
										}	
										

										if (nameValidation == ''
												|| nameValidation == null) {
											var text = "** Name is required";

											document
													.getElementById("nameValidation").innerHTML = text;
											document
													.getElementById("nameValidation").style.color = "red";
											return false;
										}
										
										
									
										

										else {

											$('#list_login_details')
													.removeClass(
															'active active_tab1');
											$('#list_login_details')
													.removeAttr(
															'href data-toggle');
											$('#login_details').removeClass(
													'active');
											$('#list_login_details').addClass(
													'inactive_tab1');
											$('#list_personal_details')
													.removeClass(
															'inactive_tab1');
											$('#list_personal_details')
													.addClass(
															'active_tab1 active');
											$('#list_personal_details')
													.attr('href',
															'#personal_details');
											$('#list_personal_details').attr(
													'data-toggle', 'tab');
											$('#personal_details').addClass(
													'active in');
										}

									});

					$('#previous_btn_personal_details')
							.click(
									function() {
										$('#list_personal_details')
												.removeClass(
														'active active_tab1');
										$('#list_personal_details').removeAttr(
												'href data-toggle');
										$('#personal_details').removeClass(
												'active in');
										$('#list_personal_details').addClass(
												'inactive_tab1');
										$('#list_login_details').removeClass(
												'inactive_tab1');
										$('#list_login_details').addClass(
												'active_tab1 active');
										$('#list_login_details').attr('href',
												'#login_details');
										$('#list_login_details').attr(
												'data-toggle', 'tab');
										$('#login_details').addClass(
												'active in');
									});

					$('#btn_personal_details')
							.click(
									function() {
										var error_first_name = '';
										var error_last_name = '';

										if (error_first_name != ''
												|| error_last_name != '') {
											return false;
										} else {
											$('#list_personal_details')
													.removeClass(
															'active active_tab1');
											$('#list_personal_details')
													.removeAttr(
															'href data-toggle');
											$('#personal_details').removeClass(
													'active');
											$('#list_personal_details')
													.addClass('inactive_tab1');
											$('#list_contact_details')
													.removeClass(
															'inactive_tab1');
											$('#list_contact_details')
													.addClass(
															'active_tab1 active');
											$('#list_contact_details').attr(
													'href', '#contact_details');
											$('#list_contact_details').attr(
													'data-toggle', 'tab');
											$('#contact_details').addClass(
													'active in');
										}
									});

					$('#previous_btn_contact_details').click(
							function() {
								$('#list_contact_details').removeClass(
										'active active_tab1');
								$('#list_contact_details').removeAttr(
										'href data-toggle');
								$('#contact_details').removeClass('active in');
								$('#list_contact_details').addClass(
										'inactive_tab1');
								$('#list_personal_details').removeClass(
										'inactive_tab1');
								$('#list_personal_details').addClass(
										'active_tab1 active');
								$('#list_personal_details').attr('href',
										'#personal_details');
								$('#list_personal_details').attr('data-toggle',
										'tab');
								$('#personal_details').addClass('active in');
							});

					/*
					 * $('#takeAllClass').click(function () {
					 * 
					 * console.log("test") var mysel =
					 * $("#takeAllClass").empty(); $ .ajax({ type : "GET", url :
					 * "/getAllClassName", success : function (result) {
					 * 
					 * console.log(result); $ .each( result, function (i,
					 * valuee) {
					 * 
					 * console .log(valuee.classesName); $( mysel) .append( $( "<option
					 * value="+valuee.coachingClassId+">") .text(
					 * valuee.classesName)); } );
					 * 
					 *  }, error : function (e) { } });
					 * 
					 * });
					 */

					$('#takeAllClass')
							.click(
									function(event) {

										$
												.ajax({
													url : '/getAllClassName',
													type : 'GET',
													contentType : 'application/json; charset=utf-8',
													dataType : 'json',

													success : function(data) {
														$("#takeAllClass")
																.empty();

														for (var key = 0; key < data.length; key++) {

															$("#takeAllClass")
																	.append(
																			"<option value='"
																					+ data[key].coachingClassId
																					+ "'>"
																					+ data[key].classesName
																					+ "</option>"

																	);

														}

													}
												});

									});

					$('#takeAllBranch')
							.click(
									function(event) {

										var ddlCustomers = $("#takeAllBranch");
										$('#takeAllBranch')
												.find('option')
												.remove()
												.end()
												.append(
														'<option value="whatever">Select</option>')
												.val('whatever')
										console.log("branch");
										$
												.ajax({
													type : "GET",
													url : "/getAllBranch",
													success : function(result) {

														console.log(result);

														$
																.each(
																		result,
																		function(
																				i,
																				val) {
																			/*
																			 * var
																			 * list = '<li><span
																			 * class="hide">'+val.noticeDetails+'</span><a
																			 * class="pend-task-list"
																			 * href="#">'+val.noticeDetails+'</a></li>';
																			 */
																			/* console.log(val.noticeDetails); */
																			$(
																					"#takeAllBranch")
																					.append(
																							$(
																									"<option>")
																									.val(
																											val.coachingBranchId)
																									.text(
																											val.branchName));
																		});

													},
													error : function(e) {

													}
												});

										$("#takeAllBranch")
												.on(
														"change",
														function() {
															// Getting Value
															var selValue = $(
																	"#takeAllBranch :selected")
																	.text();

															var setValue = $(
																	"#takeAllBranch :selected")
																	.val();
															// Setting Value
															$(
																	"#textFieldbranch")
																	.val(
																			selValue);

															$(
																	"#coachingBranchId")
																	.val(
																			setValue);
														});

									});

					$('#takeAllDepartment')
							.click(
									function(event) {

										var ddlCustomers = $("#takeAllDepartment");
										$('#takeAllDepartment')
												.find('option')
												.remove()
												.end()
												.append(
														'<option value="whatever">Select</option>')
												.val('whatever')

										console.log("branch");
										$
												.ajax({
													type : "GET",
													url : "/getAllDepartment",
													success : function(result) {

														console.log(result);

														$
																.each(
																		result,
																		function(
																				i,
																				val) {
																			/*
																			 * var
																			 * list = '<li><span
																			 * class="hide">'+val.noticeDetails+'</span><a
																			 * class="pend-task-list"
																			 * href="#">'+val.noticeDetails+'</a></li>';
																			 */
																			/* console.log(val.noticeDetails); */
																			$(
																					"#takeAllDepartment")
																					.append(
																							$(
																									"<option>")
																									.val(
																											val.coachingGroupEntityId)
																									.text(
																											val.groupName));

																		});

													},
													error : function(e) {

													}
												});

										$("#takeAllDepartment")
												.on(
														"change",
														function() {
															// Getting Value
															var selValue = $(
																	"#takeAllDepartment :selected")
																	.text();
															var setValue = $(
																	"#takeAllDepartment :selected")
																	.val();

															// Setting Value
															$(
																	"#textFieldepartment")
																	.val(
																			selValue);

															$(
																	"#coachingGroupEntityId")
																	.val(
																			setValue);
														});

									});

					$('#takeAllShift')
							.click(
									function(event) {
										console.log("shift");
										var ddlCustomers = $("#takeAllShift");
										$('#takeAllShift')
												.find('option')
												.remove()
												.end()
												.append(
														'<option value="whatever">Select</option>')
												.val('whatever')
										console.log("branch");
										$
												.ajax({
													type : "GET",
													url : "/getAllShift",
													success : function(result) {

														console.log(result);

														$
																.each(
																		result,
																		function(
																				i,
																				val) {
																			/*
																			 * var
																			 * list = '<li><span
																			 * class="hide">'+val.noticeDetails+'</span><a
																			 * class="pend-task-list"
																			 * href="#">'+val.noticeDetails+'</a></li>';
																			 */
																			/* console.log(val.noticeDetails); */
																			$(
																					"#takeAllShift")
																					.append(
																							$(

																							"<option>")
																									.val(
																											val.coachingShiftId)
																									.text(
																											val.coachingShiftName));
																		});

													},
													error : function(e) {

													}
												});

										$("#takeAllShift")
												.on(
														"change",
														function() {
															// Getting Value
															var selValue = $(
																	"#takeAllShift :selected")
																	.text();

															var setValue = $(
																	"#takeAllShift :selected")
																	.val();
															// Setting Value
															$("#textFieldshift")
																	.val(
																			selValue);
															$(
																	"#coachingShiftId")
																	.val(
																			setValue);
														});

									});

					$('#btn_personal_details').click(
							function(event) {
								event.preventDefault();

								/* var studentName = $("#stdName").val(); */

								var getForm = $("#studentFormParent");

								var response = submitCurrentForm(getForm);

								response.done(function(data) {
									/*
									 * var scope = $("#studentFormf");
									 * scope.find('#stdFormId').val(data.coachingStudentId);
									 * console.log("mumu" + data.studentName);
									 */

									$("#coachingStudentRegisterro").val(
											data.studentRegId);

								});

							});

					$('#btn_complete_reg').click(function(event) {
						event.preventDefault();

						/* var studentName = $("#stdName").val(); */

						var getForm = $("#studentFormRollId");

						var response = submitCurrentForm(getForm);

						response.done(function(data) {
							/*
							 * var scope = $("#studentFormf");
							 * scope.find('#stdFormId').val(data.coachingStudentId);
							 * console.log("mumu" + data.studentName);
							 */

							/* $("#stdRollId").val(data.studentRegId); */

						});

					});

					// Corporate General Form submittion block start
					// $('.generalView-div').hide();
					$('#sme-gen-submit')
							.click(
									function(event) {
										event.preventDefault();
										// localScope =
										// $(this).closest('.box-footer').closest('div');
										var response = submitCurrentForm($(this));

										// when success
										response
												.done(function(data) {
													// hide form
													var scope = $("#layout-general");
													scope.find('#gen-loanId')
															.val(data.loanId);

													scope
															.children('div')
															.not(
																	'.details-view-only')
															.hide();
													scope
															.find(
																	'.details-view-only')
															.removeClass('hide');

													$("#layout-form-panel")
															.removeClass('hide');
													// show response modal
													var image = '<img src="/img/success.gif"/>';
													$('#form-submition-modal')
															.find('.modal-body')
															.first()
															.empty()
															.append(
																	"Save successful.");
													var view = scope
															.find('.details-view-only');

													view.find('#ref').val(
															data.caseNo);
													view.find('#ecp').val(
															data.ecp.code);
													view.find('#sector').val(
															data.sector.name);
													view
															.find('#sectorCode')
															.val(
																	data.sector.code);
													view.find('#category').val(
															data.category.name);
													view.find('#security').val(
															data.security.code);

													view.find('#scheme').val(
															data.scheme.name);
													view.find('#purpose').val(
															data.purpose);
													view
															.find('#loanAmount')
															.val(
																	data.loanAmount);
													view.find('#period').val(
															data.period);
													view
															.find(
																	'#interestRate')
															.val(
																	data.interestRate);
													view
															.find('#date')
															.val(
																	new Date(
																			data.createdDate)
																			.toLocaleDateString());

													$(".gen-loanId-basic").val(
															data.loanId);

												});

										// when fail
										response
												.fail(function(jqXHR, exception) {
													var error = errorMessage(
															jqXHR, exception);
													console.log(exception);
													// $.setBody('<h1>'+error+'</h1>');
													$('#form-submition-modal')
															.find('.modal-body')
															.first().empty()
															.append(error);
												});

									});
					// Corporate General Form submittion block end

					$('#takeAllClass')
							.on(
									'change',
									function(event) {
										event.preventDefault();

										var variable = $(this).val();

										alert(variable);

										var optionsText = this.options[this.selectedIndex].text;
										// alert(optionsText);

										// $("#takeAllClass option<value=" +
										// variable
										// +prop("selected","selected")+ ">");
										/*
										 * $(this).("#takeAllClass
										 * option:selected").text();
										 * 
										 * alert(aa);
										 */
										// $(this).attr('disabled', 'disabled');
										/*
										 * $("#takeAllClass").find('option').attr("href",
										 * "https://www.w3schools.com/jquery/");
										 */

										// $("#takeAllClass").append(new
										// Option("option text", "value"));
										$('#takeAllClass').append(
												'<option value="' + variable
														+ '">' + optionsText
														+ '</option>');
										for (i = 0; i < 10; i++) {
											$('#takeAllClass').append(
													'<option value="' + i
															+ '">' + 'Option '
															+ i + '</option>');
										}
									}

							);

					
					
					
					
					
				});



