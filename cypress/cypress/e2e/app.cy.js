import { describe, it } from "mocha";

describe("test1", () => {
    it('passes' ,()=>{
        cy.visit("/")
    })
})    