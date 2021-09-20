import { Component, OnInit, ViewChild } from "@angular/core";
import { MatDialog } from "@angular/material/dialog";
import { map } from "rxjs";
import { DialogBoxComponent } from "src/app/dialog-box/dialog-box.component";
import { Client } from "src/app/model/client";
import { Instrument } from "src/app/model/instrument";
import { Order } from "src/app/model/order";
import { ClientService } from "src/app/service/client.service";
import { CustodianService } from "src/app/service/custodian.service";
import { InstrumentService } from "src/app/service/instrument.service";
import { OrderService } from "src/app/service/order.service";

@Component({
  selector: "app-icons",
  templateUrl: "icons.component.html"
})
export class IconsComponent {
  constructor(private dialog:MatDialog,private orderService:OrderService, private clientService:ClientService, private custodianService:CustodianService, private instrumentService:InstrumentService) {
    this.getClients();
    this.getInstruments();
  }
  @ViewChild('f')
  form:any;
  model: Order = new Order();
  Institle:string="Select Instrument ID";
  Insclient:string="Select Client ID";
  cust_name:any;
  client_name:any;
  instrument_name:any;
  clients:Client[];
  instruments:Instrument[];
  checkface:boolean=true;
  checkdate:boolean=false;
  ins_face:any;
  ins_date:any
  buttonName:any="Buy/Sell";
  status:string='';
  tid:any;
  setButton(name:any){
    this.buttonName=name;
  }
  
  getClients(){
    this.clientService.getAllClients().subscribe(
      clients=>{
        this.clients=clients;
      }
    )
    }

  getInstruments(){
    this.instrumentService.getAllInstruments().subscribe(
      instruments=>{
        this.instruments=instruments;
      }
    )
  }


  getClientName(optionSelected:any)
  {
    this.clientService.getClientNameByID(optionSelected).subscribe(client=>{
      this.client_name=client.client_name;
    })
  }

  getCustodianName(optionSelected:any){
    this.custodianService.getCustodianNameByID(optionSelected).subscribe(custodian=>{
      this.cust_name = custodian.cust_name;
    })
  }

  getInstrumentName(optionSelected:any){
    
    this.instrumentService.getInstrumentByID(optionSelected).subscribe(instrument=>{
      this.instrument_name = instrument.instrument_name;
      this.ins_date = instrument.expiry_date;
      this.ins_face = instrument.face_value;
      if(instrument.face_value==0){
        this.checkface=false;
      }
      else{
        this.checkface=true;
      }
      if(instrument.expiry_date===null){
        this.checkdate=true;
      }
      else{
      this.checkdate=false;}
    })
  }

  onSubmit(){
    const dir=<HTMLInputElement>document.getElementById('direction');
    if(dir.value=="Buy"){
      this.orderService.setBuyOrder(this.form.value).pipe(map(res =>{
      
        this.status=JSON.parse(JSON.stringify(res))["message"];
        this.tid=JSON.parse(JSON.stringify(res))["tid"];
      
         let dialogRef= this.dialog.open(DialogBoxComponent,{data:{status:this.status,tid:this.tid},disableClose:true, panelClass:'my-class'});
        dialogRef.afterClosed().subscribe(result =>{
            if(result){
              window.location.reload();
            }
          })
      })).subscribe()
    }
    else{
      this.orderService.setSellOrder(this.form.value).pipe(map(res =>{
      
        this.status=JSON.parse(JSON.stringify(res))["message"];
        this.tid=JSON.parse(JSON.stringify(res))["tid"];
        
         let dialogRef= this.dialog.open(DialogBoxComponent,{data:{status:this.status,tid:this.tid},disableClose:true, panelClass:'my-class',width: '250px',
         height: '300px'});
        dialogRef.afterClosed().subscribe(result =>{
            console.log(result);
          })
      })).subscribe()
    }
  }
}
