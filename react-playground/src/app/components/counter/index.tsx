import React, { useEffect, useState } from 'react';

interface ICounter {
    initialCount: number;
    intervalCounterSecounds?: number;
}

export default function Counter({initialCount ,intervalCounterSecounds}:ICounter) {

     const [count, setCount] = useState<ICounter>({ initialCount: initialCount, intervalCounterSecounds: (intervalCounterSecounds?? 1)*1000  })

    useEffect(() => {

 
        setInterval( ()=> {
            setCount(x => ({initialCount : x.initialCount+1}) )

        }, count.intervalCounterSecounds )
    }, [])

    // useEffect(()=>{
    //     console.log( ( new Date()).valueOf().toString() )
    //     console.log(count);
    // },[count])

    return (
        <>
            {count.initialCount} 


        </>
    );
}
