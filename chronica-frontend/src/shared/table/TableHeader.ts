export interface TableHeader<T> {
    name: string,
    field: keyof T
}