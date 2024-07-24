'use client'

import Image from "next/image";
import img1 from '../assets/react.svg'
import Counter from "./components/counter";
import { useState } from "react";
import { Container, Input } from "postcss";

export default function Home() {
  const [count, setCount] = useState<number>(0)
  return (
    <div className="">
      <Image src={img1} alt="Demo IMG"></Image>
      <hr></hr>

      Contador: <Counter initialCount={count} ></Counter>
      <div>
        <select >
          <option>2</option>
          <option>3</option>
          <option>8</option>
          <option>9</option>
        </select>
      </div>
    </div>


  );
}
