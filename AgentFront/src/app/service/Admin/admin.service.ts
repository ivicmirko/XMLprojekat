import { Injectable } from '@angular/core';
import { HttpHeaders } from '@angular/common/http';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

const adminUrl="http://localhost:8763/admin/api/admin/"

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor() { }
}
