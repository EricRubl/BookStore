import { Component, OnInit } from '@angular/core';
import { ClientsService } from '../service/clients.service';
import { MatDialog } from "@angular/material";
import { Client } from '../types';
import { ClientModalComponent } from './client-modal/client-modal.component';

@Component({
  selector: 'app-clients',
  templateUrl: './clients.component.html',
  styleUrls: ['./clients.component.css']
})
export class ClientsComponent implements OnInit {

  clients: Client[];
  displayedColumns = ['id', 'name', 'deleteColumn', 'updateColumn'];

  constructor(
    public dialog: MatDialog,
    private service: ClientsService,
  ) { }

  ngOnInit() {
    this.loadData();
  }

  loadData() {
    this.service.getClients().subscribe(resp => {
      this.clients = resp.sort((c1: Client, c2: Client) => c1.id - c2.id);
    })
  }

  handleAdd() {
    const dialogRef = this.dialog.open(ClientModalComponent, {
      width: "300px",
      data: JSON.parse(JSON.stringify({}))
    });

    dialogRef.afterClosed().subscribe((result: Client) => {
      if (result) {
        this.service.addClient(result).subscribe(_ => {
          this.loadData();
        });
      }
    });
  }

  handleDelete(id: number) {
    this.service.deleteClient(id).subscribe(_ => {
      this.loadData();
    });
  }

  handleUpdate(client: Client) {
    const dialogRef = this.dialog.open(ClientModalComponent, {
      width: "300px",
      data: JSON.parse(JSON.stringify(client))
    });

    dialogRef.afterClosed().subscribe((result: Client) => {
      if (result && result.id) {
        this.service.updateClient(result).subscribe(_ => {
          this.loadData();
        });
      }
    });
  }
}
