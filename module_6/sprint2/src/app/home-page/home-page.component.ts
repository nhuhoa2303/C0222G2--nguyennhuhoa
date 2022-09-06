import {Component, OnInit} from '@angular/core';
import {ProductService} from "../service/ProductService";
import {Product} from "../model/Product";

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {
  productList: Product[] = [];
  p: number = 1;
  productNearDayList: Product[] = [];

  constructor(private productService: ProductService) {
  }

  ngOnInit(): void {
    this.getAll();
    this.getProductNearDay();
  }


  private getAll() {
    this.productService.getAll().subscribe(d => {
      this.productList = d;
    })
  }


  private getProductNearDay() {
    this.productService.getProductNearDay().subscribe(d => {
      this.productNearDayList = d;
    })
  }
}
