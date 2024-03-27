import { Products } from "./products.interface";

export interface ProductsResult {
    products: Products[],
    limit: number,
    skip: number,
    total: number
}
