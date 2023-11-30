import React, { useEffect } from 'react';

const ExampleComponent = () => {
  // componentDidMount
  useEffect(() => {
    console.log('Inside mount');

    // componentWillUnmount
    return () => {
      console.log('Inside unmount');
    };
  }, []); // Empty dependency array means it will only run once on mount

  // componentDidUpdate
  useEffect(() => {
    console.log('Inside update');

    // This cleanup function will run before the component updates
    return () => {
      console.log('Inside cleanup of the previous update');
    };
  });

  return (
    <div>
      <h2>Example Component</h2>
      <p>This component demonstrates the useEffect hook.</p>
    </div>
  );
};

export default ExampleComponent;

