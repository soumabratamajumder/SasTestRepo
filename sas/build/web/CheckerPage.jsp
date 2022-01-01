<%-- 
    Document   : CheckerPage
    Created on : Dec 6, 2021, 12:17:41 PM
    Author     : soumabratamajumder
--%>

<%@page import="common.CommonMethod"%>
<%
    String ddlDist = "";
    String ddlLoc = "";
    String eduQly = "";
    String occupation = "";
    common.CommonMethod cm = new CommonMethod();
    ddlDist = cm.getDistrict("-Please Select-");
    // ddlLoc = cm.getLocation("-Please Select-");
    //  eduQly = cm.getEducationQly("-Please Select-");
    //  occupation = cm.getOccupation("-Please Select-");
    String regMsg = "";
    String type = "light";
%>   
<!DOCTYPE html>
<html lang="en">

    <head> 
  
        <title>SAS </title>
        <jsp:include page="import/headerlogin.jsp"></jsp:include>  
            <link href="assets/css/lib/toastr/toastr.min.css" rel="stylesheet">
            <link href="assets/css/lib/select2/select2.min.css" rel="stylesheet">
            <style>
                .media{
                    height: 50px;
                }
                .table tbody tr.highlight td {
                    background-color: #cce0ff; font-weight: bold;
                }
                .dataTables_wrapper{
                    padding-left: 5px;
                    padding-right: 5px;
                }
                .modal-backdrop
                {
                    opacity:0.5 !important;
                }
                .font-text
                {
                    font-size: .9rem;
                }
                .field-container {
                    display: inline-block;
                    font-size: 0.6rem;
                }

            </style>
        </head>

        <body>
        <jsp:include page="import/sidebarmenu.jsp"></jsp:include>  

            <div class="content-wrap">
                <div class="main">
                    <div class="container-fluid">
                        <div style="min-height: 75vh; display: flex; flex-direction: column;">
                            <div class="row" style="height: 40px;">
                                <div class="col-lg-8 col-sm-6 p-r-02 title-margin-right" style="padding-top: 0px; padding-bottom: 0px;">
                                    <div class="page-header">
                                        <div class="page-title">
                                            <h1> <span> </span></h1>
                                        </div>
                                    </div>
                                </div>
                                <!-- /# column -->
                                <div class="col-lg-4 col-sm-6 p-l-02 title-margin-left" style="padding-top: 0px; padding-bottom: 0px;">
                                    <div class="page-header" style="margin:  0 0 0 0;">
                                        <div class="page-title" style="margin:  0 0 0 0;">
                                            <ol class="breadcrumb">
                                                <li class="breadcrumb-item"><a href="#">Menu</a></li>
                                                <li class="breadcrumb-item active">SAS Form</li>
                                            </ol>
                                        </div>
                                    </div>
                                </div>
                                <!-- /# column -->
                            </div>
                            
                            <section id="main-content">
           
                                <div class="tab-content">
                                    <div class="tab-pane active" id="tab-table">
                                    <table id="pendingTable" class="table table-striped table-bordered" cellspacing="0" width="100%">
                                                    <thead>
                                                        <tr>
                                                            
                                                           
                                                            <th>Serial Number</th>
                                                            <th>RC Number</th>
                                                            <th>RC Member ID</th>
                                                            <th>Head Of The Family</th>
                                                            <th>Name</th>
                                                            <th>Date Of Entry</th>
                                                            <th id="selectBttn">Select</th>
                                                        </tr>
                                                    </thead>
                                                  </table> 
                                                </section>
                            
                            
                   <jsp:include page="import/footer.jsp"></jsp:include>    

</body>
<script>
   $(document).ready(function () { 
   var table = $('#pendingTable').DataTable({
       "bInfo": false, //Dont display info e.g. "Showing 1 to 4 of 4 entries"
       "paging": false, //Dont want paging                
       "bPaginate": false, //Dont want paging   
       "bFilter": false, //hide Search bar
       "dom": '<"toolbar">frtip',
       "ajax": {
                "url": "${pageContext.request.contextPath}/sasApiTest?pid=1",
                "type": "POST"
            },
    beforeSend: function () {},
    complete: function (data) {},
    "columnDefs": [{
                    "targets": -1,
                    "responsivePriority": 1,
                    "data": null,
                    "defaultContent": "<button type='button' value='1' class='btn btn-primary btn-flat btn-addon m-b-10 m-l-5 aadhaarKyc' data-toggle='modal' data-target='#selectBttn'><i class='ti-arrow-circle-right'></i>&nbsp;</button>"
                   }                 
                  ],
    "aoColumns": [
                  {"data": "sl"},
                  {"data": "rc_ration_card_no"},
                  {"data": "rc_ration_card_memberid"},
                  {"data": "rc_is_hof"},
                  {"data": "final_member_name_en"},
                  {"data": "uploaddatetime"},
                  {"data": null}
                 ]
    
    });

    $('#pendingTable tbody').on('click', 'button', function (e) {
 

        if (parseInt(this.value) === 1) {
            var table2 = $('#pendingTable').DataTable();
            var rowRcData = table2.row($(this).parents('tr')).data(); //alert(table2.row($(this).parents('tr')).data());


           window.location.href = "approverPage.jsp?memberid=" +rowRcData['rc_ration_card_memberid'];
            //   }); //   end ekyc aadhaar click

        } // end if value =1
    });


});

</script>