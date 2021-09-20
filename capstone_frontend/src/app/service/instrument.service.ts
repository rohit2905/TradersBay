import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, tap } from 'rxjs';
import { Instrument } from '../model/instrument';

@Injectable({
  providedIn: 'root'
})
export class InstrumentService {

  constructor(private http:HttpClient) { }


  getAllInstruments():Observable<Instrument[]>{
    let url="http://localhost:8282/api/instruments";
    return this.http.get<Instrument[]>(url).pipe()
    
  }

  getInstrumentByID(id:any):Observable<Instrument>{
    let url= "http://localhost:8282/api/instrument/"+id;

    return this.http.get<Instrument>(url).pipe()
  }
}
